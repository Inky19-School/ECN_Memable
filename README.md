# Memable

Memable est une application qui a pour but de faciliter l'édition d'image et de vidéo sur mobile dans le but de créer des memes. L'application est loin d'être finie et la plupart des fonctionnalités n'ont pas été implémentées.

## Objectif
L'objectif de cette version de l'application est de tester le design et d'expérimenter avec le passage d'information entre la page d'accueil et la page d'édition. La grande majorité des boutons présents ne sont donc pas implémentés mais sont uniquement là pour illustrer le concept d'interface.

## Page d'accueil

La page d'accueil présente les dernières images éditées par l'utilisateur ainsi que des suggestions de la journée à partir d'une base de données en ligne. En raison d'un manque de temps, il n'a pas été possible d'implémenter la base de données. les images sont stockées directement dans l'application lors de la compilation et ne servent que de placeholder.

On y retrouve :
- la liste des images récentes (vide lors du lancement avec un texte en placeholder). Cette liste se parcours de manière horizontale.
- les suggestions qui se parcours verticalement. Chaque image peut être cliquée, ce qui l'envoie directement sur la page d'édition.
- la barre de navigation en bas de l'écran (non fonctionnelle, à l'exception du bouton `+` qui crée une image vide)
- la barre du haut qui contient la zone de recherche (non implémentée par l'absence de temps et de base de données) et un bouton profil pour ouvrir un menu avec des options supplémentaires.

## Page d'édition

La page d'édition illustre comment un éditeur d'image/vidéo pourrait être implémenté sur mobile. Les boutons ne sont pas fonctionnelles, mais possèdent déjà des aspects pour réduire le nombre d'erreurs de la part de l'utilisateur (ex : champ de la taille des polices limité aux valeurs numérique).

L'image qui est passée lors de la création de l'activité est affichée au centre de l'écran. On peut ensuite la sauvegarder en appuyant sur le bouton contenant une icône de disquette. Cette action renvoie également l'image à la page d'accueil. L'utilisateur peut également sortir de l'éditeur par la flèche en haut à gauche (ou en appuyrant sur retour) ce qui ne renvoie rien.

## Choix techniques et difficultés rencontrées

- Le passage d'image se fait en convertissant chaque fichier en un tableau d'octets correpondant à la bitmap, puis est reconstruite dans l'activité qui reçoit l'information. Cette décision a été prise par manque de temps et pour garantir la copie de l'image, cependant cela limite la taille des images qui peuvent être utilisées (car les intents ne peuvent contenir qu'une certaine quantité de données de l'ordre quelques dizaines de ko). Il serait préférable de passer par une autre méthode (tel qu'un dossier externe ou une `room`).
- La rotation horizontale n'est pas complètement fonctionnelle sur l'écran d'édition par manque de temps.
- La rotation a été bloquée sur la page d'accueil, par manque de temps pour construire un layout adapté.
