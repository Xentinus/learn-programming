
// CallBack Hell

getUser(1, (user) => {
  getRepositories(user.gitHubUsername, (repos) => {
    getCommits(repos[0], (commits) => {
      console.log(commits);
    });
  })
});

// Promises

getUser(1)
  .then(user => getRepositories(user.gitHubUsername))
  .then(repos => getCommits(repos[0]))
  .then(commits => console.log(commits))
  .catch(err => console.log('Error', err.message));

// Async - await

async function displayCommits() {
  try {
    const user = await getUser(1);
    const repos = await getRepositories(user.gitHubUsername);
    const commits = await getCommits(repos[0]);
    console.log(commits);
  } catch (err) {
    console.log('Error', err.message);
  }
}

displayCommits();

// Functions

function getUser(id) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {  // 3
      console.log('Reading a use from a database...');
      resolve({ id: id, gitHubUsername: 'mosh' });
    }, 2000);
  });
}

function getRepositories(gitHubUsername) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      console.log('Calling GitHub API (repos)...');
      /* resolve([gitHubUsername, 'repo2', 'repo3']); */
      reject(new Error('Could not get the repos.'));
    }, 2000);
  });
}

function getCommits(repo) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      console.log('Calling GitHub API (commits)...');
      resolve(['comit']);
    }, 2000);
  });
}
