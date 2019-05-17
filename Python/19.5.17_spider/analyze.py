#coding=utf-8
from bs4 import BeautifulSoup
#全部的收缩结果
def parseHtml(text):
    soup = BeautifulSoup( text, features="lxml" )
    tags = soup.find_all( 'span' )
    #寻找所有的span标签
    for tag in tags:
        cont = tag.string
        if( cont is not None and cont.startswith( '百度为您找到相关结果约' )):
            #此处可进行查询优化
            cont = cont.lstrip( '百度为您找到相关结果约' )
            cont = cont.rstrip( '个' )
            cont = cont.replace( ',', '' )
            return eval(cont)

def printurl(text):
    #打印出所有搜索结果中网站的URl以及网站名字
    soupurl = BeautifulSoup( text, features="lxml" )
    #通过分析，搜索结果的标题都是存放在h3中的
    tagsurl = soupurl.find_all( 'h3' )
    #使用循环将网站以及对应的url传入到字典中
    dicturl = {}
    for tagurl in tagsurl:
        url = [x['href'] for x in tagurl.select('a')][0]
        #使用列表生成式子，以及select方法提取搜索结果的url
        dicturl.update({tagurl.get_text():url})
    return dicturl

#排除广告
def parseHtmlSel(text):
    soupSel = BeautifulSoup( text, features="lxml" )
    tagsSel = soupSel.find_all('a')
    sum = 0
    #用于计数
    for tagSel in tagsSel:
        if(tagSel.string == "广告"):
        #求取单个页面不是广告的搜索条目的个数
            sum += 1
    return sum

def EndSel(text):
    #用于结束搜索的函数
    flag = True
    temp = []
    soupEnd = BeautifulSoup( text, features="lxml" )
    #通过分析，搜索结果的标题都是存放在h3中的
    tagsEnd = soupEnd.find_all( 'a' )
    for tagEnd in tagsEnd:
        temp.append(tagEnd.string)
    if('下一页>' not in temp):
        flag = False
    return flag