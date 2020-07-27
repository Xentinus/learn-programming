
/* Async - Non blocking

Before
After
Reading a use from a database...

*/

// Sync - Blocking

console.log('Before'); // 1
setTimeout(() => {  // 3
  console.log('Reading a use from a database...');
}, 2000);
console.log('After'); // 2

