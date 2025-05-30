const mongoose = require('mongoose');
const Product = require('./models/Product');
require('dotenv').config();

mongoose.connect(process.env.MONGO_URI, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

const categories = ['Electronics', 'Clothing', 'Books', 'Home', 'Beauty'];

const seedProducts = async () => {
  await Product.deleteMany({});

  const products = [];

  for (let i = 1; i <= 100; i++) {
    products.push({
      name: `Product ${i}`,
      price: Math.floor(Math.random() * 1000),
      category: categories[Math.floor(Math.random() * categories.length)],
      inStock: Math.random() > 0.5,
    });
  }

  await Product.insertMany(products);
  console.log("Database seeded!");
  mongoose.connection.close();
};

seedProducts();