package org.zerock.myapp.util;

import javafx.scene.Node;
import javafx.scene.Parent;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;


@Log4j2
public abstract class CommonUtil {


    public static void doTraverseByHierarchy(Node node, int depth) {
        if(depth == 0) log.trace("*********************************************");

        // log.trace("{}[{}]. doTraverseByHierarchy({}) invoked.", "\t".repeat(depth), depth, node);
        log.trace("{}[{}]. {}", "\t".repeat(depth), depth, node);

        Objects.requireNonNull(node, "Depth(%s) node is NULL.".formatted(depth));

        if(node instanceof Parent parent) {
            parent.getChildrenUnmodifiable().
                forEach(n -> CommonUtil.doTraverseByHierarchy(n, depth + 1));
        } // if

        if(depth == 0) log.trace("*********************************************");
    } // doTraverseByHierarchy

} // end class
