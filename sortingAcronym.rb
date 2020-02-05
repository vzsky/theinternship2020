num = gets.to_i
all = Array.new
for i in 1..num
    string = gets.chomp
    strlist = string.gsub(/\s+/, ' ').strip.split(" ")
    abbr = ""
    for word in strlist
        abbr << /[[:upper:]]/.match(word[0]).to_s
    end
    all.push(abbr)
end
all.sort! { |a,b| a.length == b.length ? a <=> b : b.length-a.length }
puts all