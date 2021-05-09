const express = require('express');
const {google} = require('googleapis');
require('dotenv').config({ debug: true });

const {
  YOUR_CLIENT_ID,
  YOUR_CLIENT_SECRET
} = process.env;
const redirect_uri = 'http://localhost:3000/oauth2callback'
const scope = 'email'

const app = express()

// AuthUrlを生成してloginページに遷移
app.get('/login', (req, res) => {
  const OAuth2 = google.auth.OAuth2;
  const oauth2Client = new OAuth2(
    YOUR_CLIENT_ID,
    YOUR_CLIENT_SECRET,
    redirect_uri
  );
  const authorizeUrl = oauth2Client.generateAuthUrl({
    access_type: 'offline',
    scope
  });
  res.redirect(302, authorizeUrl)
})

// 上のリダイレクトで帰ってくるcodeを用いてTokenを取得して、ユーザー情報を取る
app.get('/oauth2callback', (req, res) => {
  const OAuth2 = google.auth.OAuth2;
  const oauth2Client = new OAuth2(
    YOUR_CLIENT_ID,
    YOUR_CLIENT_SECRET,
    redirect_uri
  );

  oauth2Client.getToken({
    code: req.query.code,
    YOUR_CLIENT_ID,
    redirect_uri
  }).then(result => {
    return oauth2Client.getTokenInfo(result.tokens.access_token)
  }).then(result => {
    // result内のsub情報がアカウント共通でかつuniqueなのでこの情報を保持すれば良さそう
    console.dir(result);
    res.end(result.email);
  });;
})

app.listen(3000, () => console.log('listening on port 3000'))
