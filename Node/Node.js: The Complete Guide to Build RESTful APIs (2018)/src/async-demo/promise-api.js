
const p = Promise.reject(new Error('reason for rejection'));
p.catch(error => console.log(error));

/*
new Error-ként kell írni mert akkor több a detail
ha csak szimplán string akkor csak a szöveget írja ki
*/

const a = Promise.resolve({ id: 1 });
a.then(result => console.log(result));