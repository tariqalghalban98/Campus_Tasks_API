const http = require('http');
const url = require('url');

const server = http.createServer((req, res) => {

  if (req.url === '/') {
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(`
      <html>
        <body style="font-family: Arial; text-align: center; margin-top: 50px;">
          <h1>Campus Tasks - Age Calculator</h1>
          <p>Enter your birth year to calculate your age:</p>
          <form action="/calculate" method="GET">
            <input type="number" name="year" placeholder="e.g. 2002" required>
            <button type="submit">Calculate</button>
          </form>
        </body>
      </html>
    `);
  } 
  
  else if (req.url.startsWith('/calculate')) {
    const queryObject = url.parse(req.url, true).query;
    const birthYear = parseInt(queryObject.year);
    const currentYear = new Date().getFullYear();
    const age = currentYear - birthYear;

    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(`
      <html>
        <body style="font-family: Arial; text-align: center; margin-top: 50px;">
          <h1>Your Age is: ${age} years</h1>
          <a href="/">Go Back</a>
        </body>
      </html>
    `);
  }
});

server.listen(8080, () => {
  console.log('Server is running on port 8080');
});