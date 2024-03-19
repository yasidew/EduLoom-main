const express = require('express');
const multer = require('multer');

const app = express();
const PORT = process.env.PORT || 3000;
const upload = multer({ dest: 'uploads/' });

app.use(express.json());

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

let posts = []; // array to store posts

app.get('/posts', (req, res) => { // get all posts
    res.json(posts);
})


//create new post

app.post('posts', (req, res) => {
    const {title, body} = req.body; // get title and body from request body
    const newPost = {id: posts.length + 1, title, body};
    posts.push(newPost);
    res.status(201).json(newPost); 
});


//get post by id

app.get('/posts/:id', (req, res) => {
    const postId = parseInt(req.params.id); // get post id from request params
    const post= posts.find(post => post.id === postId);
    if (post) {
        res.json(post);
    }else{
        res.status(401).json({message : 'post not found'});
    }
});


//update post by id

app.put('/posts/:id', (req, res) => {
    const postId = parseInt(req.params.id);
    const {title, body} = req.body; 
    const post = posts.find(post => post.id === postId);

    if(post){
        post.title = title;
        post.body = body;
        res.json(post);
    }else{
        res.status(404).json({message: 'post not found'});
    }
});


//delete post by id
app.delete('/posts/:id', (req, res)=>{
    const postId = posts(req.params.id);
    const index = posts.findIndex(post => post.id === postId); //index is the position of the post in the array
    if(index !== -1){
        posts.splice(index, 1); // remove the post from the array
        res.json({message: 'post deleted'});
    }else{
        res.status(404).json({message: 'post not found'});
    }
});



//route for handling file uploads
app.post('/upload', upload.single('image'), (req, res) => {
    // File is uploaded and available in req.file
    res.json({ message: 'File uploaded successfully', file: req.file });
});

//  route for paginated posts
app.get('/posts', (req, res) => {
    const page = parseInt(req.query.page) || 1;
    const limit = parseInt(req.query.limit) || 10;

    const startIndex = (page - 1) * limit;
    const endIndex = page * limit;

    const paginatedPosts = posts.slice(startIndex, endIndex);

    res.json({ page, limit, data: paginatedPosts });
});




app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`)
})