java ProfileTest
java  -prof:prof11.log tuning.profile.ProfileTest
java ProfileTest
java  "-Xrunhprof:cpu=samples,file=prof12.log" ProfileTest
 
java -Xprof ProfileTest > prof13b.log
javah tuning.profile.ProfileTest
javah -Xprof tuning.profile.ProfileTest > profH.log

