#find . \( ! -regex '.*/\..*' \) -type f | xargs sed -i 's/<manuel\.dahmen@gmx\.com>/_manuel.dahmen@gmx.com_/g'
#find . \( ! -regex '.*/\..*' \) -type f | xargs sed -i 's/<manuel\.dahmen@gmail\.com>/_manuel.dahmen@gmx.com_/g'
find . \( ! -regex '.*/\..*' \) -type f | xargs sed -i 's/one.empty3.library/one.empty3.library/g'