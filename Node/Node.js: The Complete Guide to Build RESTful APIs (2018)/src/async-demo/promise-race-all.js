const p1 = new Promise((resolve, reject) => {
  setTimeout(() => {
    console.log('Async operation 1...');
    resolve(1);
    //reject(new Error('Some Error'));
  }, 2000);
});

const p2 = new Promise((resolve) => {
  setTimeout(() => {
    console.log('Async operation 2...');
    resolve(2);
  }, 1000);
});

// Ha bármelyik be failol-akkor csak errort fog kidobni
// Result: array
Promise.all([p1, p2])
  .then(result => console.log(result))
  .catch(err => console.log('Error', err));

// Amelyik elöbb befejezödik az lesz a gyöztes és annak a resultja jelenik meg
// Result: első tartalma
Promise.race([p1, p2])
  .then(result => console.log(result))
  .catch(err => console.log('Error', err));