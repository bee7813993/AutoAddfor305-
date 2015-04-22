# AutoAddfor305zt
マイワイモバイルにアクセスして、自動的に容量追加をするSeleniumプログラム。

第1引数にマイワイモバイルのログインID
第2引数にマイワイモバイルのパスワード
を指定して実行すると
4分おきにマイワイモバイルにアクセスして、
低速化解除予約、もしくは低速化解除をしようと試みます。

Java版 Seleniumで動きます。

知り合い以外からの使い方とかの質問は受け付けないので、自己解決してください。
また、トラブルが発生しても自己責任でお願いします。

## コマンド実行のオプションだけ説明

環境を整備してコマンドラインから以下のように実行すると動きます。(EclipseでプロジェクトのArgumentsに引数を設定してRunでもOK)

`java -classpath %CLASSPATH% update305zt.update305zt_201503.class [loginID] [loginPassword] [webdriverpath]`

- loginID : マイワイモバイルにログインするときのログインID(きっと契約電話番号)
- loginPassword : マイワイモバイルにログインするときのパスワード
- webdriverpath : chromedriver.exe ファイルのフルパス (省略するとコマンド実行しているディレクトリのchromedriver.exeを使おうとします)

