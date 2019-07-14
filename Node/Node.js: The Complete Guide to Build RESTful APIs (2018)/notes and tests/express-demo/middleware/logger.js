
function log(req, res, next) {
  console.log('Logging...');
  next(); // kell hogy tovább menjen a middleware, különben megáll a consoleban a loggingnál és nem kap választ a kliens
}

module.exports = log;
