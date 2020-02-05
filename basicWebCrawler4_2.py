from flask import Flask, jsonify
import basicWebCrawler4_1 as data

app = Flask(__name__)

@app.route('/companies', methods=['GET'])
def com () :
    return jsonify({"companies":data.companies_list})

if __name__ == "__main__" :
    app.run(port=80, host='0.0.0.0')