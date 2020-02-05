from bs4 import BeautifulSoup
import requests
import json

url = 'http://theinternship.io'
crawl  = requests.get(url).content
soup = BeautifulSoup(crawl, features="html.parser")
soup.prettify()

soup.find_all("div.partner")
partners = soup.find_all("div", {"class": "partner"})

companies = {}
logos = []
companies_list = []
for partner in partners :
    logo = partner.find("div", {"class" : "logo-box"}).find("a").find('img')['src']
    companies_list.append({"logo" : logo})
    logos.append(logo)
    companies[logo] = len(partner.find("div", {"class": "box-textbox"}).find("span").get_text())

# print(companies)
sorted_companies = sorted(companies.items(), key=lambda item: item[1])

if __name__ == "__main__" :
    for company in sorted_companies :
        print(company[0])