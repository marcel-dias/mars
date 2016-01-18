FROM jboss/wildfly:9.0.2.Final

ENV MARS_VERSION 1.0
ENV WILDFLY_DEPLOYMENT $JBOSS_HOME/standalone/deployments/

RUN cd $WILDFLY_DEPLOYMENT \
    && curl -LSso mars.war https://github.com/marceldiass/maven-repo/raw/releases/io/github/marceldiass/mars/$MARS_VERSION/mars-$MARS_VERSION.war

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]