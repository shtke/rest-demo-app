# rest-demo-app
以下のGitHubのAPIよりデータを取得し、レスポンスに存在するtitleの先頭10文字、bodyの先頭30文字をレスポンスとして返却するRESTful API。<br>
https://api.github.com/repos/spring-projects/spring-boot/issues?page=1&per_page=10

GitHub APIへのリクエスト、レスポンスの内容はログとして、以下のファイルに出力される。<br>
rest-demo-app/logs/rest-client.log

## 

## Requirement
- java8
- maven 3.6.2

## Usage
- アプリケーションの起動
```bash
git clone https://github.com/shtke/rest-demo-app.git
cd rest-demo-app
mvn spring-boot:run
```
- 動作確認

Github APIからデータを取得する際のリクエストパラメータとしてデフォルト値（page=1, per_page=10）を利用する場合<br>
```bash
curl http://localhost:8080/demo/issues
```
Github APIからデータを取得する際のリクエストパラメータをデフォルト値から変更したい場合<br>
```bash
curl http://localhost:8080/demo/issues?page=2&per_page=5
```
