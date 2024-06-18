# Markdown 教程
## 二级标题
### 三级标题
#### 四级标题

## 段落  
行末加两个空格表示换行

## 字体  
*斜体文本*  
_斜体文本_  
**粗体文本**   
__粗体文本__  
***粗斜体文本***  
___粗斜体文本___  
  
 ## 分割线  
 ***  
 * * *
 *****
 - - -
 --------------

 ## 删除线  
 ~~Baidu.com~~

 ## 下划线  
 <U>带下划线的文本<U>  

 ## 脚注  
 [^要注明的文本]  

 ## 列表  
 ### 无序列表  
 * 第一项
 * 第二项
 * 第三项
  
  + 第四项
  + 第五项
  - 第六项

### 有序列表
1. 第一项
2. 第二项
3. 第三项

### 列表嵌套

列表嵌套只需在子列表中的选项前面添加两个或四个空格即可：

1. 第一项  
    - 第一项  
    - 第二项  
2. 第二项
    + 第一项
    + 第二项
    + 第三项

## 区块

> 区块使用列表  
> 1. 第一项  
    > 财年  
    > cc 

> 2. 第二项
> 

## 代码  
·printf()· 函数  

## 代码区块  
    <?php  
    echo 'RUNOOB';  
    function test() {    
       echo 'test';  
    }

    '''javascript
    $(document).ready(function (){
        alert('RUNOOB');
    })

    '''


## 链接  
这是一个链接（http://www.baidu.com）  
<http:www.baidu.com>  

这个链接用 1 作为网址变量 [Google][1]  
这个链接用 runoob 作为网址变量 [Runoob][runoob]  
然后在文档的结尾为变量赋值（网址）  

  [1]: http://www.google.com/
  [runoob]: http://www.runoob.com/

## 图片  
![alt 图标](https://www.google.com/imgres?q=tup&imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fen%2Fthumb%2Fc%2Fc8%2FTechnological_University_of_the_Philippines_Seal.svg%2F800px-Technological_University_of_the_Philippines_Seal.svg.png&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FTechnological_University_of_the_Philippines&docid=qP6fALMeh9MCMM&tbnid=PgqRbGnX7zAogM&vet=12ahUKEwiToJjvtJaFAxVzl1YBHceBD9kQM3oECBYQAA..i&w=800&h=800&hcb=2&ved=2ahUKEwiToJjvtJaFAxVzl1YBHceBD9kQM3oECBYQAA)



## 表格  
| 左对齐 | 右对齐 | 居中对齐 |
| :-----| ----: | :----: |
| 单元格 | 单元格 | 单元格 |
| 单元格 | 单元格 | 单元格 |


## 高级技巧  

支持的 HTML 元素
不在 Markdown 涵盖范围之内的标签，都可以直接在文档里面用 HTML 撰写。

目前支持的 HTML 元素有：<kbd> <b> <i> <em> <sup> <sub> <br>等 ，如：

使用 <kbd>Ctrl</kbd>+<kbd>Alt</kbd>+<kbd>Del</kbd> 重启电脑

## 转义
Markdown 使用了很多特殊符号来表示特定的意义，如果需要显示特定的符号则需要使用转义字符，Markdown 使用反斜杠转义特殊字符：

**文本加粗** 
\*\* 正常显示星号 \*\*

## Markdown 支持以下这些符号前面加上反斜杠来帮助插入普通的符号：

\\   反斜线  
\`   反引号  
\*   星号  
\_   下划线  
\{}  花括号  
\[]  方括号  
\()  小括号  
\#   井字号  
\+   加号  
\-   减号  
\.   英文句点  
\!   感叹号  

## 公式
Markdown Preview Enhanced 使用 KaTeX 或者 MathJax 来渲染数学表达式。

KaTeX 拥有比 MathJax 更快的性能，但是它却少了很多 MathJax 拥有的特性。你可以查看 KaTeX supported functions/symbols 来了解 KaTeX 支持那些符号和函数。

默认下的分隔符：

$...$ 或者 \(...\) 中的数学表达式将会在行内显示。
$$...$$ 或者 \[...\] 或者 ```math 中的数学表达式将会在块内显示。

$$
\begin{Bmatrix}
   a & b \\
   c & d
\end{Bmatrix}
$$
$$
\begin{CD}
   A @>a>> B \\
@VbVV @AAcA \\
   C @= D
\end{CD}
$$

$$ sin30 * cos60 = 1

