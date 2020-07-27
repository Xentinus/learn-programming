// Trade off between query perfomance vs consistency

// Using References (Normalization) -> CONSISTENCY
let author = {
  id: 2342342,
  name: "Mosh"
}

let course = {
  author: 2342342,
  name: 'Sajtos Course'
}

// Using Embedded Documents (Denormalization) -> PERFORMANCE
let course = {
  author: {
    name: 'Mosh'
  }
}

// Hybrid
let author = {
  name: 'Mosh'
  // 50 other properties
}

let course = {
  author: {
    id: 'ref',
    name: 'Mosh'
  }
}