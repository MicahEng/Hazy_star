#coding=utf-8
import socket
import urllib.request
import urllib.error
 
def baiduText(code, num):
    url = 'http://www.baidu.com/s?wd=' + code + '&pn=' + str(num)
    try:
        response = urllib.request.urlopen(url, timeout = 10)#下载页面，设定延迟10s
        return response.read().decode('gbk', ‘ignore’).encode('utf-8')
    except urllib.error.URLError as e:  #抛出异常
        if isinstance(e.reason, socket.timeout):
            print('TIME OUT')
         
def saveDict(dict):
    # 将字典保存问txt文件
    file = open('dict.txt', 'a') 
    for k,v in dict.items():
        file.write(k+'\n'+v+'\n')
    file.close()