#first commit on github
git init
git branch -M main
git add .
git commit -m "first commit"
gh repo create StarFleetReservation --public
git remote add origin https://github.com/JXPM/StarFleetReservation.git
git push --set-upstream origin main

#fichier Maj et push
git status
git add .
git commit -m "Maj"
git push origin main
