package com.infoshareacademy.menu;

import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowByOrganizer {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void showByOrganizer() {
        FilterRepository filterRepository = new FilterRepository();
        int submenu2ExitCode = 0;

        while (submenu2ExitCode != 9) {
            stdout.info("\n");
            new PrintHeader().printHeader();
            stdout.info("│   1. Pokaż ....                                    │\n");
            stdout.info("│   2. Pokaż .....                                   │\n");
            stdout.info("│   2. Pokaż ........                                │\n");
            stdout.info("│                                                    │\n");
            stdout.info("│  \u001b[36m 9. Wróć                                 \u001b[0m         │\n");
            stdout.info("│                                                    │\n");
            stdout.info("└────────────────────────────────────────────────────┘\n");
            stdout.info("\n");
            stdout.info("Wpisz liczbę: \n");

            switch (GetChoice.getChoice()) {
                case 1:
                    stdout.info(filterRepository.filterAllOrganisers("Archipelag").toString());
                    break;
                case 2:
                    stdout.info(filterRepository.filterAllOrganisers("biblioteka").toString());
                    break;
                case 3:
                    stdout.info(filterRepository.filterAllOrganisers("miniatura").toString());
                    break;
                case 9:
                    stdout.info("        POWRÓT DO WYŻSZEGO POZIOMU       \n\n");
                    submenu2ExitCode = 9;
                    break;
                case 0:
                    break;
                default:
                    new PrintNothingHere().printNothingHere();
            }
        }
    }
}
