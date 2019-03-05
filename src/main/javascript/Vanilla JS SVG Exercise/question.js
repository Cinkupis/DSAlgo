/*
    The goal of this exercise is to take a polygon defined by the points 'points', use the mouse
    events to draw a line that will split the polygon and then draw the two split polygons.
    In the start, you'll have the initial polygon (start.png)
    While dragging the mouse, the polygon should be shown along with the line you're drawing (mouseMove.png)
    After letting go of the mouse, the polygon will be split into two along that line (mouseUp.png)

    The code provided here can be used as a starting point using plain-old-Javascript, but it's fine
    to provide a solution using react/angular/vue/etc if you prefer.
*/

const line = [];

function onMouseDown(event) {
    line.push({x: event.layerX, y: event.layerY});
}

function onMouseMove(event) {
    if (line.length == 0) {
        return;
    }

    if (line.length == 2) {
        line.pop();
    }
    
    line.push({x: event.layerX, y: event.layerY});
    clearPoly();
    addPoly(points);
    drawLine();
}

function onMouseUp(event) {
    const poly1 = [];
    const poly2 = [];
    const twoIntersections = [];
    const pointsWithIntersections = [];

    for (let i = 0; i < points.length; i++) {
        let next = (i == points.length - 1) ? 0 : i + 1;
        let intersection = getLineIntersectionCoordinates(points[i], points[next], line[0], line[1]);
        pointsWithIntersections.push(points[i]);
        if (intersection.intersectsPoly && intersection.intersectsDrawn) {
            twoIntersections.push({x: intersection.x, y: intersection.y});
            pointsWithIntersections.push({x: intersection.x, y: intersection.y});
        }
    }

    if (twoIntersections.length >= 2) {
        let putInPoly1 = true;
        for (let i = 0; i < pointsWithIntersections.length; i++) {
            if (putInPoly1) {
                poly1.push(pointsWithIntersections[i]);
                if (pointsWithIntersections[i].x == twoIntersections[0].x && pointsWithIntersections[i].y == twoIntersections[0].y) {
                    putInPoly1 = false;
                    poly2.push(pointsWithIntersections[i]);
                }
            } else {
                poly2.push(pointsWithIntersections[i]);
                if (pointsWithIntersections[i].x == twoIntersections[1].x && pointsWithIntersections[i].y == twoIntersections[1].y) {
                    putInPoly1 = true;
                    poly1.push(pointsWithIntersections[i]);
                }
            }
        }
    }

    line.splice(0, line.length);
    addPoly(poly1, 'blue');
    addPoly(poly2, 'green');
}

// Math used from https://en.wikipedia.org/wiki/Line%E2%80%93line_intersection#Given_two_points_on_each_line
function getLineIntersectionCoordinates(polyLinePoint1, polyLinePoint2, drawnLinePoint1, drawnLinePoint2) {
    var intersection = {
        x: null,
        y: null,
        intersectsPoly: false,
        intersectsDrawn: false
    };

    var denominator = (polyLinePoint1.x - polyLinePoint2.x) * (drawnLinePoint1.y - drawnLinePoint2.y) -
            (polyLinePoint1.y - polyLinePoint2.y) * (drawnLinePoint1.x - drawnLinePoint2.x);
    
    // Lines don't intersect if denominator is 0.
    if (denominator == 0) {
        return intersection;
    }

    // Intersection given lines are continued indefinitely into both directions
    intersection.x = ((polyLinePoint1.x * polyLinePoint2.y - polyLinePoint1.y * polyLinePoint2.x) * (drawnLinePoint1.x - drawnLinePoint2.x) -
            (polyLinePoint1.x - polyLinePoint2.x) * (drawnLinePoint1.x * drawnLinePoint2.y - drawnLinePoint1.y * drawnLinePoint2.x)) / denominator;

    intersection.y = ((polyLinePoint1.x * polyLinePoint2.y - polyLinePoint1.y * polyLinePoint2.x) * (drawnLinePoint1.y - drawnLinePoint2.y) -
            (polyLinePoint1.y - polyLinePoint2.y) * (drawnLinePoint1.x * drawnLinePoint2.y - drawnLinePoint1.y * drawnLinePoint2.x)) / denominator;

    // t - determines if intersection falls on polyLine
    var t = ((polyLinePoint1.x - drawnLinePoint1.x) * (drawnLinePoint1.y - drawnLinePoint2.y) - 
            (polyLinePoint1.y - drawnLinePoint1.y) * (drawnLinePoint1.x - drawnLinePoint2.x)) / denominator;

    // u - determines if intersection falls on drawnLine
    var u = -1 * ((polyLinePoint1.x - polyLinePoint2.x) * (polyLinePoint1.y - drawnLinePoint1.y) -
            (polyLinePoint1.y - polyLinePoint2.y) * (polyLinePoint1.x - drawnLinePoint1.x)) / denominator;

    // if 0.0 <= t <= 1.0 then intersection falls on polygon line
    if (0 <= t && t <= 1) {
        intersection.intersectsPoly = true;
    }

    // if 0.0 <= u <= 1.0 then intersection falls on drawn line
    if (0 <= u && u <= 1) {
        intersection.intersectsDrawn = true;
    }

    return intersection;
};

function drawLine() {
    var newLine = document.createElementNS('http://www.w3.org/2000/svg','line');
    newLine.setAttribute('x1', line[0].x);
    newLine.setAttribute('y1', line[0].y);
    newLine.setAttribute('x2', line[1].x);
    newLine.setAttribute('y2', line[1].y);
    newLine.setAttribute('stroke', 'red');
    document.getElementById('content').lastChild.appendChild(newLine);
}

/*
	Code below this line shouldn't need to be changed
*/

//Draws a polygon from the given points and sets a stroke with the specified color
function addPoly(points, color = 'black') {
    if(points.length < 2) {
        console.error("Not enough points");
        return;
    }
    
    const content = document.getElementById('content');
    
    var svgElement = document.createElementNS("http://www.w3.org/2000/svg", 'svg');
    var svgPath = document.createElementNS("http://www.w3.org/2000/svg", 'path');
    let path = 'M' + points[0].x + ' ' + points[0].y
    
    for(const point of points) {
        path += ' L' + point.x + ' ' + point.y;
    }
    path += " Z";
    svgPath.setAttribute('d', path);
    svgPath.setAttribute('stroke', color);
    
    svgElement.setAttribute('height', "500"); 
    svgElement.setAttribute('width', "500");
    svgElement.setAttribute('style', 'position: absolute;');
    svgElement.setAttribute('fill', 'transparent');
    
    svgElement.appendChild(svgPath);
    content.appendChild(svgElement);
}

//Clears the all the drawn polygons
function clearPoly() {
    const content = document.getElementById('content');
    while (content.firstChild) {
        content.removeChild(content.firstChild);
    }
}

//Sets the mouse events needed for the exercise
function setup() {
    this.clearPoly();
    this.addPoly(points);
    document.addEventListener('mousemove', onMouseMove);
    document.addEventListener('mousedown', onMouseDown);
    document.addEventListener('mouseup', onMouseUp);
}

const points = [
    { x : 100, y: 100 },
    { x : 200, y: 50 },
    { x : 300, y: 50 },
    { x : 400, y: 200 },
    { x : 350, y: 250 },
    { x : 200, y: 300 },
    { x : 150, y: 300 },
]

window.onload = () => setup()




























