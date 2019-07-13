const p = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve(1); // pending => resolved, fulfilled
    reject(new Error('message')); // pending => rejected
  }, 2000);

});

p.then(resolve => console.log('Result', resolve)).catch(err => console.log('Error', err.message));
