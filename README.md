### spring-rest-docs-sample
#### 推奨環境
* JDK 1.8
#### ramlファイルを作成するのに準備すること
raml2htmlをinstallする
```aidl
npm i -g raml2html

npm i -g raml2html-markdown-theme
```

#### raml形式のAPI仕様書の作成の仕方
クローンしたディレクトリへ移動してビルドする
```aidl
gradle build
```

ramlファイルを生成する
```aidl
gradle ramldoc
```

ramlファイルをhtmlファイルに変換して開く
```aidl
raml2html ./build/ramldoc/api.raml > ./build/ramldoc/api.raml.html
open ./build/ramldoc/api.raml.html
```