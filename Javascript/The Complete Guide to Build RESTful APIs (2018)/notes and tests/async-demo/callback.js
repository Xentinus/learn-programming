
// Synch
console.log('Before');
const user = getUser(1);
const repos = getRepositories(user.gitHubUsername);
console.log('After');

// Asynch

console.log('Before'); // 1
getUser(1, (user) => {
  console.log('User', user);
  // Get the repositories
  getRepositories(user.gitHubUsername, (repos) => {
    console.log('Repos', repos);
    getCommits(repo, displayCommits);
    // CALLBACK HELL
  })
});
console.log('After'); // 2

function displayCommits(commits) {
  console.log(commits);
}

function getUser(id, callback) {
  setTimeout(() => {  // 3
    console.log('Reading a use from a database...');
    callback({ id: id, gitHubUsername: 'mosh' });
  }, 2000);
}

function getRepositories(gitHubUsername, callback) {
  setTimeout(() => {
    console.log('Calling GitHub API...');
    callback([gitHubUsername, 'repo2', 'repo3']);
  }, 2000);
}
