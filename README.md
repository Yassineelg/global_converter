# Global Converter

![Global_Converter](https://github.com/Yassineelg/global_converter/assets/68504782/2c17a73c-efc3-4bd6-bcbb-6a55c2861aad)

Global Converter est une application Java permettant de traduire des messages entre différentes bases numériques, notamment décimale, binaire, octale et hexadécimale. Ce projet a été réalisé dans le cadre du test d'admission à La Plateforme en 2ème année.

## Utilisation

Pour compiler le projet, utilisez la commande suivante :

```bash
make all
```

Pour compiler le projet et lancer les 20 tests unitaires, utilisez la commande suivante :

```bash
make test
```

Pour supprimer tous les fichiers .class compilés présents dans le dossier (mais pas les sous-dossiers), utilisez la commande suivante :

```bash
make clean
```

Pour effectuer une suppression complète (compilation + nettoyage), utilisez la commande suivante :

```bash
make re
```

Une fois le projet compilé, vous pouvez l'utiliser comme suit :

```bash
java GlobalConverter <base> <string> [key <encryption key>]
```

Les valeurs possibles pour `<base>` sont les suivantes :

**hexadecimal**
**octal**
**decimal**
**binary**
**text**
**-h**
**-o**
**-d**
**-b**
**-t**

La valeur de `<string>` doit être une chaîne de caractères ne contenant que des caractères alphabétiques et/ou numériques.

L'argument optionnel `[key <encryption key>]` correspond à une fonctionnalité de chiffrement qui n'est pas encore implémentée.

Ceci est la fin du Readme. Merci de votre attention !
