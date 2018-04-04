# ハンズオン

## 課題の目的

Fuse(Camel)からDrools(DecisionManager)で記述したルール(drl)をDecisionManagerが提供するRealtime Decision Server経由で呼び出せるようにする

## 課題の内容

order-apiエンドポイント(REST GET形式)経由でcamel-sqlコンポーネント呼ばれた直後にRealtime Decision Serverを呼び出す

呼び出した先で、OrderくらすのitemフィールドにCamelという文字が入っていると50%OFFという文字列をdescriptionフィールドの末尾に追加する

Realtime Decision Serverの呼び出しは、RHDM7.0のGetting Started Guideにしたがって、Javaクライアントを呼び出す形式とする

Realtime Decision Serverの呼び出しは、org.apache.camel.Processorインターフェースを実装したCamelプロセッサー内で行う.

将来のAPI変更に備えて、このDrools固有の処理はプロセッサー内で完結するようにする.

