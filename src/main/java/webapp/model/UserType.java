package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by vssmirnov on 02.11.2016.
 */
public enum UserType {
    /// <summary>
    /// unregistered
    /// </summary>
    unregistered,

    /// <summary>
    /// registered
    /// </summary>
    registered,

    /// <summary>
    /// moderator
    /// </summary>
    moderator,

    /// <summary>
    /// does_not_exist
    /// </summary>
    does_not_exist
}
