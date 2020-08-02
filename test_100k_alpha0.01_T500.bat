javac Main.java

java Main -fnTrainData ./ml-100k/train_5.csv -fnTestData ./ml-100k/test_5.csv -n 943 -m 1349 -alpha 0.01 -gamma 0.01 -T 1000 -topK 20 -d 20 >RESULT/test_100k_alpha0.01_T500.txt