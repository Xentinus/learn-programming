var url = 'http://mylogger.io/blog';

console.log(__filename); // teljes út a fájlig (fájlnévvel együtt)
console.log(__dirname); // teljes út a mappáig amiben van

function log(message) {
  // Send an HTTP request
  console.log(message);
}

// module.exports.log = log; // ha többet portálsz
module.exports = log; // ha csak egy cuccot exportálsz
// module.exports.endPoint = url; // csak végterméket adunk vissza, nem kell mindent átadni
