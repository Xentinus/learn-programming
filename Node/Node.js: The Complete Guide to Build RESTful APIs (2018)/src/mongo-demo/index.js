// connect to mongodb
const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/playground') // playground database, automatic create if not exist
  .then(() => console.log('Connected to MongoDB'))
  .catch(err => console.log('Could not connect to MongoDB...', err));

/*  Schema types
String, number, date, buffer (bindary data), boolean, objectID (sign in unique cucc), array
*/

const courseSchema = new mongoose.Schema({
  name: String,
  author: String,
  tags: [String],
  date: { type: Date, default: Date.now },
  isPublished: Boolean
});

const Course = mongoose.model('Course', courseSchema); // Course Class -> course, nodeCourse = human, béla

async function createCourse() {
  const course = new Course({
    name: 'Angular Course',
    author: 'Mosh',
    tags: ['angular', 'frontend'],
    isPublished: true
  });

  const result = await course.save();
  console.log(result);
}

async function getCourses() {
  // Comparison Query Operators

  // eq (equal)
  // ne (not equal)
  // gt (greater than)
  // gte (greaten than or equal to)
  // lt (less than)
  // lte (less than or equal to)
  // in
  // nin (not in)

  // Logical Operators

  // or
  // and

  // Regular Expressions

  // /^Mosh/    ami Mosh-al kezdődik
  // /Mosh$/    Mosh-al fejeződik be
  // .*Mosh.*   Mosh-t tartalmazza

  // /api/courses?pageNumber=2&pageSize=10
  const pageNumber = 2;
  const pageSize = 10;

  const courses = await Course
    .find({ author: 'Mosh', isPublished: true }) // követelmények
    // .find({ price: { $gte: 10, $lte: 20 } }) // 10-20 közöttiek
    // .find({ price: { $in: [10, 15, 20] } }) // az arrayben valamelyik
    // .or([{ author: 'Mosh' }, { isPublished: true }]) // ha valamelyik igaz akkor azt kidobja, find után
    // .find({ author: /^Mosh/ }) // Starts with mosh
    // .find({ author: /Hamedani$/ }) // Ends with Hamedani
    // .find({ author: /.*Mosh.*/ }) // Contains Mosh
    // .skip((pageNumber - 1) * pageSize) // lapozás
    .limit(10) // csak tiz darab // pageSize ha lapozásos
    .sort({ name: 1 }) // ASC order: 1 DESC order: -1
    .select({ name: 1, tags: 1 }); // csak nevet és tageket jelenit meg (defaultként az id-t is megjelenití)
  // .count() // Csak megjeleníti hogy mennyi ilyen van (.countDocuments()-kell már használni régit veszik ki!)
  console.log(courses);
}

async function updateCourse(id) {
  // Approach: Query first, findById(), Modify its properites, save()
  const course = await Course.findById(id);
  if (!course) return;

  if (course.isPublished) return;

  course.isPublished = true;
  course.author = "Another author";
  // course.set({
  //   isPublished: true,
  //   author: "Another author"
  // });

  const result = await course.save();
  console.log(result);

  // Approach 2: Update first, update firectly, Optionally: get the updated document
  const result = await Course.update({ _id: id }, {
    $set: {
      author: 'Mosh',
      isPublished: false
    }
  });

  console.log(result);
}

async function deleteCourse(id) {
  const result = await Course.deleteOne({ _id: id }); // csak az elsőt törli mait igy talál (deleteMany ha több)
  const result2 = await Course.findByIdAndRemove(id);
  console.log(result2);
}

deleteCourse('5c03504919749d34f58bf901');
// updateCourse('5c03504919749d34f58bf901');
// createCourse();
// getCourses();