
public class Do {

	public static void main(String[] args) {
		const express = require('express');
		const bodyParser = require('body-parser');

		jjjjjconsthhh app = express();

		app.use(bodyParser.json());

		app.post('/', (req, res) => {
		  res.json(req.body);
		});

		app.listen(3000, () => console.log('server started'));
	}

}
