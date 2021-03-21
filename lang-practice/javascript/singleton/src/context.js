const {objectA} = require('./objectA');
const objectB = require('./objectB');

const Context = class {
    objectA
    objectB
    constructor() {
        this.objectA = objectA;
        this.objectB = new objectB(10, 10);
    }
};

module.exports = Context;
