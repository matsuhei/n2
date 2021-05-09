# OAuth2認証について勉強

## 目的
- ユーザーの認証をOAuthを用いてできるようにしたい

## やったこと
- OAuthについて、フローの理解し直し
- google oauthを用いて認証部分の実装

## OAuthについて
- サービスプロバイダのユーザー情報を利用して認証を行う仕組み
- サービス側からサービスプロバイダへのリクエストに必要なトークンをログイン時に取得して、リクエスト可能な状態にする

```mermaid
sequenceDiagram
participant 1 as ユーザー
participant 2 as サービス
participant 3 as サービスプロバイダ

Note over 1, 2: ユーザーログイン

1->>+2: ログイン
2-->>-1: ログインページリダイレクト
1->>+3: ログインページリダイレクト
3-->>-1: ログイン完了リダイレクト
Note over 3: queryにrequestToken
1->>+2: ログイン完了リダイレクト
2->>2: ユーザー情報の取得<br>及びサービス側のデータ確認
2-->>-1: ログイン完了

```


## 参考URL
- [Oauth for goole](https://developers.google.com/identity/protocols/oauth2)
- [OpenIdConnect](https://developers.google.com/identity/protocols/oauth2/openid-connect)
- [一番分かりやすい OAuth の説明](https://qiita.com/TakahikoKawasaki/items/e37caf50776e00e733be)