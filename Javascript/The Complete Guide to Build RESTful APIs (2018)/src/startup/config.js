const config = require('config');

module.exports = function () {

  // Before start
  // export vidly_jwtPrivateKey=mySecureKey

  if (!config.get('jwtPrivateKey')) {
    throw new Error('FATAL ERROR: jwtPrivateKey is not defined.');
  }
};

