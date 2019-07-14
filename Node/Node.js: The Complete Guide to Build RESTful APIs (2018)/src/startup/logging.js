const winston = require('winston');
// require('winston-mongodb');
require('express-async-errors');

module.exports = function () {

  // Log Levels: error / warn / info / verbose / debug / silly

  // Process - exceptions
  // process.on('uncaughtException', (ex) => {
  //   winston.error(ex.message, ex);
  //   process.exit(1);
  // });

  winston.handleExceptions(
    new winston.transports.Console({ colorize: true, prettyPrint: true }),
    new winston.transports.File({ filename: 'uncaughtExceptions.log' }));

  // Process - Rejections
  process.on('unhandledRejection', (ex) => {
    throw ex;
  });

  // File Logging
  winston.add(winston.transports.File, { filename: 'logfile.log' });

  // Database Logging
  // winston.add(winston.transports.MongoDB, { db: 'mongodb://localhost/vidly', level: 'error' });
};

