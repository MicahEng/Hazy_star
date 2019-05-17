#coding=utf-8
from download import *
from analyze import *
def main():
    global sum
    n = 0
    num = input('请输入要查询的股票：')
    text = baiduText(num, n*10)
    number = parseHtml(text)
    print('由股票关键字直接收缩的结果：' + str(number))
    sum = numberSel = parseHtmlSel(text)
    
    #下载第一个页面的url
    dict = printurl(text)
    saveDict(dict)
    print('将搜索结果及网站存放在dict.txt文件中,请等待加载......')
    
    #在主函数中定义流程，对所有的页面进行遍历
    flag = EndSel(text)
    print(111111)
    while(flag):
        print(22222)
        n += 1
        text = baiduText(num, n*10)
        dict = printurl(text)
        saveDict(dict)
        sum += parseHtmlSel(text)
   
    print('经过对搜索结果存在广告的页面段进行排除得到的搜索结果：' + str(number - sum))
    
if __name__ == '__main__':
    main()