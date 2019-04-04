#!/bin/bash
#awk '/.exec/ && !g {f=1;g=1} /.headers/ {f=0} {printf "%s%s",$0,(f?FS:RS)}' FU2.scala
#sed 'N;exec/s/\n\s*//;P;D' FileList*
#sed 's/username=[a-z0-9_]+/username=abc/i' Service.properties
#:/TESTOUT/s/_9/_FOO/
#sed -e 's|:umask=022:|:umask=022:\'$'\n\t\t:charset=UTF-8:|g'
# Headers first
#sed -e ':a;N;$!ba;s/exec/LALALALALALALLALALALALLLALALLALLALALLALAL/g' FU2.scala > blah

#sed 's/$//g' FU2.scala > 2.tmp

cat FU2.BAK > 1.tmp
sed -e '/\"X-/N; s/\n/ /;' 1.tmp>b.tmp
sed -e '/\"Origin/{N; s/\n/ /;}' b.tmp>c.tmp
sed -e '/\"Accept/N; s/\n/ /;P;D' c.tmp>d.tmp
sed -e '/\"Upgrade-/{N; s/\n/ /;}' d.tmp>e.tmp
sed -e '/\"Content-/{N; s/\n/ /;}' e.tmp>f.tmp
sed -e '/\"Requested-/{N; s/\n/ /;}' f.tmp>g.tmp
sed -e '/Map(/{N; s/\n/ /;}' g.tmp>h.tmp
sed -e "s/	//g" h.tmp>i.tmp
sed -e '/\.exec/{N; s/\n/ /;}' i.tmp>j.tmp
sed -e "s/.resources/.exec/g" j.tmp > k.tmp
sed -e "s/  http/.exec(http/g" k.tmp > l.tmp

#sed -e "s/RawFile/ElFile/g" 23.tmp>25.tmp
#sed -e '/get/{N; s/\n/ /;}' 26.tmp>27.tmp
#sed -e "s/.pause/\/\/.pause/g" 27.tmp>28.tmp
#sed -e "s/          .exec/.exec/g" 28.tmp>29.tmp
#sed -e '/\.headers/{N; s/\n/ /;}' 29.tmp>30.tmp




#sed -e "/$^/d" 23.tmp > 24.tmp
#sed -e 'N;/headers/s/\n//;P;D' 25.tmp > 26.tmp
#sed -e "s/Map(	/Map(/g" 19.tmp > 20.tmp
#sed 'N;/X-/s/\n//;P;D' 8.tmp > 9.tmp
#sed 'N;/Accept/s/\n//;P;D' 9.tmp > 10.tmp
#sed 'N;/Upgrade-/s/\n//;P;D' 10.tmp > 11.tmp
#sed 'N;/Content-/s/\n//;P;D' 11.tmp > 12.tmp
#sed 'N;/Origin/s/\n//;P;D' 12.tmp > 13.tmp
#sed 'N;/Requested-/s/\n//;P;D' 13.tmp > 14.tmp
#sed 'N;/Accept-Encoding/s/\n//;P;D' 15.tmp > 16.tmp
#sed 'N;/\n\n/s/\n\n/\n/;P;D' 16.tmp > 17.tmp


#sed -e "s/	//g" FU2.scala>1.tmp
#sed -e "s/Map(		/Map(/g" 2.tmp > 3.tmp
#sed -e "s/)			/) /g" 4.tmp > 5.tmp
#sed -e "s/),/))/g" 7.tmp>8.tmp
#sed -e 'N;/.headers/s/\n//;P' 9.tmp > 10.tmp
#sed -e '/.headers/s/\n//;P;D' 9.tmp > 10.tmp

#sed 'N;/.options/s/\n//;P;D' F3.tmp > T1.tmp
#sed 'N;/.post/s/\n//;P;D' T1.tmp > T2.tmp
#sed 'N;/.head(/s/\n//;P;D' T2.tmp > T3.tmp
#sed 'N;/.delete(/s/\n//;P;D' T3.tmp > T4.tmp



