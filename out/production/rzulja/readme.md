Program generuje fraktal julii.
W głównej klasie w zależności od mocy obliczeniowej komputera deklarujemy zmienną scale: na i5 4460 3 robi robotę.
Zmienna Rzec reprezentuje część rzeczywistą punktu c.
Zmienna uroj reprezentuje część urojoną punktu c.
iterMAX to zmienna ile iteracji obliczenia fraktali ma być.
CUTOFF to tak jak na wykładzie określa "skończoność" rysowania fraktalu.
Program dzieli całe płótno na 4 części i wykonuje na oddzielnym wątku swoją częsć.
Program czeka na zakończenie wątków roboczych.
Pokazuje ile czasu zajeły obliczenia, następnie generuje plik w którym narysuje fraktal.
