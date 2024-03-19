const jwt = require('jsonwebtoken');
const secretKey = 'your-secret-key';

// Middleware function to verify JWT token
const authenticateToken = (req, res, next) => {
    const token = req.headers['authorization'];
    if (token == null) return res.sendStatus(401); // Unauthorized

    jwt.verify(token, secretKey, (err, user) => {
        if (err) return res.sendStatus(403); // Forbidden
        req.user = user;
        next();
    });
};

//  route that requires authentication
app.get('/protected-route', authenticateToken, (req, res) => {
    res.json({ message: 'Authenticated successfully' });
});

//  route for user login
app.post('/login', (req, res) => {
    
    const user = { username: 'exampleUser' };

    const accessToken = jwt.sign(user, secretKey);
    res.json({ accessToken });
});
