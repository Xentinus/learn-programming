
// _id: 5c145ccbf8cf7f2d8c3079d1

// 12 bytes

/*
  first 4 bytes: timestamp
  next 3 bytes: machine indentifier
  next 2 bytes: process  indentifier
  last 3 bytes: counter
*/

const mongoose = require('mongoose');

const id = new mongoose.Types.ObjectId();
console.log(`ID: ${id}`);
console.log(`Timestamp: ${id.getTimestamp()}`);


console.log(mongoose.Types.ObjectId.isValid('1234'));