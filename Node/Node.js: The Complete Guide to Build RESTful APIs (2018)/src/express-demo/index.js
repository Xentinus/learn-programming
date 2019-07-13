const debug = require('debug')('app:startup'); // export DEBUG=app:startup,app:db vagy ha minden akkor DEBUG=app:*
// const dbDebugger = require('debug')('app:db') // namespace, kell róla info!
const config = require('config'); // config mappa betöltő - export NODE_ENV=development
const Joi = require('joi'); // kiveszi a cigányságokat
const logger = require('./middleware/logger'); // külső fájból való inportálás
const courses = require('./routes/courses');
const home = require('./routes/home');
const express = require('express');
const helmet = require('helmet'); // Helmet helps you secure your Express apps by setting various HTTP headers.
const morgan = require('morgan'); // tiny morgan: GET /api/courses 200 82 - 2.550 ms
const app = express();

// nem nagyon szokták használni, azért mutatta be hogy teljes legyen a tutorial
app.set('view engine', 'pug'); // nem kell be requirezni, tudni fogja
app.set('views', './views'); // a default ./views

/* console.log(`NODE_ENV: ${process.env.NODE_ENV}`); // alapba undefined
console.log(`app: ${app.get('env')}`);*/

app.use(express.json()); // json middleware
app.use(express.urlencoded({ extended: true })); //key=value & key=value  = x-www-form-urlencoded
app.use(express.static('public'));
app.use(helmet());
app.use('/api/courses', courses); // ha valamelyik az /api/courses-t keresi azt a courses routerbe tereli
app.use('/', home);

// Configuration
console.log('Application Name: ' + config.get('name'));
console.log('Mail server: ' + config.get('mail.host'));
console.log('Mail server password: ' + config.get('mail.password')); // ha nincs definiálva kibasz az egész egy throw-al

if (app.get('env') === 'development') {
  app.use(morgan('tiny'));
  debug('Morgan enabled...');
}

app.use(logger);

// dbDebugger('Connected to the database...'); // lehet igy is indítani: $ DEBUG=app:db node index.js

/* app.use(function (req, res, next) {
  console.log('Authenticating...');
  next();
}); */

// Ha van alap port akkor azt használja
const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Listening on port ${port}...`));
