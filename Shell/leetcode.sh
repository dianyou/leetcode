195. Tenth Line
  sed -n '10p' file.txt
  awk 'NR==10' file.txt
  #从第十行开始显示文件
  tail -n+10 file.txt | head -n 1
194. Transpose File
# awk命令
awk '{
  for(i=1;i<=NF;i++)
  {
    if(NR ==1)  s[i] = $i;
    else s[i] = s[i]" "$i;
  }
} END{
  for(i=1;s[i] != "";i++){
    print s[i];
  }
}' file.txt

193. Valid Phone Numbers
#grep
grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt
#sed
sed -nr '/^(\([0-9]{3}\) ){1}[0-9]{3}-[0-9]{4}$|^([0-9]{3}-){2}[0-9]{4}$/p' file.txt
#awk
awk '/^(\([0-9]{3}\) ){1}[0-9]{3}-[0-9]{4}$|^([0-9]{3}-){2}[0-9]{4}$/' file.txt

192. Word Frequency

awk '
BEGIN{

while(getline < "words.txt") {
        for(i=1;i<=NF;i++) {
                freq[$i]++;
        }
}

n = asort(freq, dest);
for(word in freq) {
        reversefreq[freq[word]] = word;
}

for (j=n;j>=1;j--) {
        print reversefreq[dest[j]]" "dest[j];
}

}'

#较慢
tr -s "\t| " "\n" <words.txt|sort |uniq -c | sort -k1 -r|awk '{print $2,$1}'
