const logger = require('./logger');
// anti overwrite
// console.log(logger); // Exportált functionok lecheckolása

// logger.log('message'); // a több
logger('message'); // ha csak egy function
