
const EventEmitter = require('events');
// const emitter = new EventEmitter(); // class tehát ha loggerben is van akkor az másiknak számít

// Register a listener

/*
emitter.on('messageLogged', function (arg) { // e, eventArg, arg -t szoktak használni
  console.log('Listener called', arg);
});
*/

const Logger = require('./logger');
const logger = new Logger();

logger.on('messageLogged', (arg) => { // arrow function
  console.log('Listener called', arg);
})

/*
emitter.on('messageLogged', (arg) => { // arrow function
  console.log('Listener called', arg);
})
*/

// Raise an event
// emitter.emit('messageLogged', { id: 1, url: 'http://' });

logger.log('message');
