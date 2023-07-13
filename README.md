# overview

Java + LiveDataを使ったRoomの技術調査用アプリ

# スレッドセーフなsingleton instanceの扱いについて
[document](https://developer.android.com/training/data-storage/room?hl=ja#database)やroomの内部実装を見ると、RoomDatabaseやdaoをシングルトンで扱うことを推奨している。なので、<br>
https://github.com/LeoAndo/RoomJavaSample/blob/main/app/src/main/java/com/leoleo/roomjavasample/roomjavasample/data/DataModule.java<br>
上記のようにコードを作成しているが、こちらの実装はroomの自動生成ファイル(java)やjetpackの内部コードなどを参考にした。<br>

### jetpackの内部コード datastore
https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:datastore/datastore-rxjava3/src/main/java/androidx/datastore/rxjava3/RxDataStoreDelegate.kt?hl=ja
<img width="675" alt="スクリーンショット 2023-07-13 23 53 34" src="https://github.com/LeoAndo/RoomJavaSample/assets/16476224/b96b8bd5-86b1-4812-8368-a5405dc8364f">

### android roomの自動生成ファイル(java)
<img width="786" alt="スクリーンショット 2023-07-13 23 48 13" src="https://github.com/LeoAndo/RoomJavaSample/assets/16476224/e8949d1c-f8fb-4463-96bd-2d27cae448ca">
<img width="714" alt="スクリーンショット 2023-07-13 23 48 04" src="https://github.com/LeoAndo/RoomJavaSample/assets/16476224/be3ed6f4-cac0-4fec-a977-d526408a7f89">


# capture

<img src=./1.png width=50%/>
