const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/playground')
  .then(() => console.log('Connected to MongoDB...'))
  .catch(err => console.error('Could not connect to MongoDB...', err));

const authorSchema = new mongoose.Schema({
  name: String,
  bio: String,
  website: String
});

const Author = mongoose.model('Author', authorSchema);

const Course = mongoose.model('Course', new mongoose.Schema({
  name: String,
  authors: [authorSchema]
}));

async function createCourse(name, authors) {
  const course = new Course({
    name,
    authors
  });

  const result = await course.save();
  console.log(result);
}

async function listCourses() {
  const courses = await Course.find();
  console.log(courses);
}

async function updateAuthor(courseId) {
  const course = await Course.findById(courseId);
  course.authors.name = 'Mosh hamedani';
  course.save();
}

async function updateInstant(courseId) {
  const course = await Course.updateOne({ _id: courseId }, {
    $unset: {
      'authors': ''
    }
  });
}

async function addAuthor(courseId, author) {
  const course = await Course.findById(courseId);
  course.authors.push(author);
  course.save();
}

async function removeAuthor(courseId, authorId) {
  const course = await Course.findById(courseId);
  const author = course.authors.id(authorId);
  author.remove();
  course.save();
}

// updateInstant('5c11415f62a4602c7c0cc419');
// updateAuthor('5c11415f62a4602c7c0cc419');
// addAuthor('5c11415f62a4602c7c0cc419', new Author({ name: 'Amy'}));
// removeAuthor('5c11415f62a4602c7c0cc419', '5c11415f62a4602c7c0cc419');
createCourse('Node Course', [
  new Author({ name: 'Mosh' }),
  new Author({ name: 'Kesey' })
]);
