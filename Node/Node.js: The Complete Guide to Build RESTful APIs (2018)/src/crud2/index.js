const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/mongo-exercises').then(console.log('Connected to MongoDB')).catch(err => console.log(err.message));

const courseSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    minlength: 5,
    maxlength: 255,
    //match: /pattern/
  }, // kötelező
  category: {
    type: String,
    required: true,
    enum: ['web', 'mobile', 'network'],
    lowercase: true, // lowercase-ként menti el nem pedig Web-ként pl
    // uppercase: true
    trim: true
  }, // 1et tartalmaznia kell kötelezően
  author: String,
  tags: {
    type: Array,
    validate: {
      isAsync: true,
      // validator: function (v) { // Sync
      //   return v && v.length > 0; // v have a value and at least have 1 value in the array
      // },
      validator: function (v, callback) { // Async
        setTimeout(() => {
          const result = v && v.length > 0;
          callback(result);
        }, 4000);
      },
      message: 'A course should have at least one tag.'
    }
  },
  date: { type: Date, default: Date.now },
  isPublished: Boolean,
  price: {
    tpye: Number,
    // min: 10, // date-hez is // hiba
    // max: 200 // hiba
    // getter: v => Math.round(v),
    // setter: v => Math.round(v)
    // required: function () { return this.isPublished; } // hiba // arrowval nem megy, nem lehet kicsapni a thist
  }
});

const Course = mongoose.model('Course', courseSchema);

async function createCourse() {
  const course = new Course({
    name: 'Angular Course366',
    category: 'Web',
    author: 'Mosh',
    tags: ['frontend'],
    isPublished: true,
    price: 15.8
  });

  try {
    const result = await course.save();
    console.log(result);
  } catch (err) {
    for (field in err.errors) {
      console.log(err.errors[field].message);
    }
  }
}

createCourse();