const Context = require('./context');

const context = new Context();

console.log(context);
console.log(context.objectA === 'objectA');
console.log(context.objectB.height === 10);
console.log(context.objectB.width === 10);
